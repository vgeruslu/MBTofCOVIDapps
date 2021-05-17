package qub.vg05.systemui.utils;

import org.graphwalker.core.machine.Context;
import org.graphwalker.core.machine.Machine;
import org.graphwalker.core.model.Edge;
import org.graphwalker.core.model.Element;
import org.graphwalker.core.model.Model;
import org.graphwalker.core.model.Vertex;
import org.joda.time.*;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import qub.vg05.systemui.tests.TestLogOutputConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ExcelMapData {

    public void createMapData(Machine machine){

        TestLogOutputConfiguration.ModelDurationMap.put("TotalStepCount", Integer.parseInt("0"));
        List<String> modelNameList = new ArrayList<>();
        TestLogOutputConfiguration.ModelDurationMap.put("ModelNameList", modelNameList);
        List<Context> contextList = machine.getContexts();
        for (Context context : contextList) {
            setMapBefore(context.getModel());
        }

    }

    public void setMapBefore(Model.RuntimeModel model){

        ConcurrentHashMap<String,Integer> vertexNumberMap = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Object> elementMap = new ConcurrentHashMap<>();
        String modelName = model.getName().trim();
        ((List<String>) TestLogOutputConfiguration.ModelDurationMap.get("ModelNameList")).add(modelName);
        List<Vertex.RuntimeVertex> modelVertexList = new ArrayList<>();
        List<Edge.RuntimeEdge> modelEdgeList = new ArrayList<>();
        List<String> vertexNameList = new ArrayList<>();
        List<String> edgeNameList = new ArrayList<>();
        for(Element element: model.getElements()) {
            if (element instanceof Vertex.RuntimeVertex) {
                Vertex.RuntimeVertex vertexElement = (Vertex.RuntimeVertex) element;
                modelVertexList.add(vertexElement);
                vertexNameList.add(vertexElement.getName().trim());
            } else {
                Edge.RuntimeEdge edgeElement = (Edge.RuntimeEdge) element;
                modelEdgeList.add(edgeElement);
                edgeNameList.add(edgeElement.getName().trim());
            }
        }
        elementMap.put("vertexNameList", setVertex(modelName, modelVertexList, vertexNameList, elementMap, vertexNumberMap));
        elementMap.put("edgeNameList", setEdge(modelName, modelEdgeList, edgeNameList, elementMap, vertexNumberMap));
        TestLogOutputConfiguration.ModelDurationMap.put(modelName, elementMap);
    }

    public List<String> setVertex(String modelName, List<Vertex.RuntimeVertex> vertexList, List<String> vertexNameList, ConcurrentHashMap<String, Object> elementMap, ConcurrentHashMap<String,Integer> vertexNumberMap){

        String vertexName;
        ConcurrentHashMap<String, Object> map;
        List<Integer> list;
        for(int i=0; i < vertexList.size(); i++){
            map = new ConcurrentHashMap<>();
            list = new ArrayList<>();
            Vertex.RuntimeVertex vertex = vertexList.get(i);
            vertexName = vertex.getName().trim();

            vertexNumberMap.put(vertexName, i+1);

            map.put("elementId", vertex.getId().trim());
            map.put("stepNumberList", list);
            map.put("stepCount", Integer.parseInt("0"));
            List<String> requirementList = new ArrayList<>();
            vertex.getRequirements().parallelStream().forEach(requirement -> requirementList.add(requirement.getKey()));
            map.put("requirements", requirementList);
            elementMap.put(vertexName, map);
            TestLogOutputConfiguration.ModelDurationMap.put(vertex.getId().trim() + modelName, vertexName);
        }
        return vertexNameList;
    }

    public List<String> setEdge(String modelName, List<Edge.RuntimeEdge> edgeList, List<String> edgeNameList, ConcurrentHashMap<String, Object> elementMap, ConcurrentHashMap<String,Integer> vertexNumberMap){

        String edgeName;
        ConcurrentHashMap<String, Object> map;
        List<Integer> list;
        List<String>  elementNameList = new ArrayList<>();
        String sourceVertex;
        String targetVertex;
        for(int i=0; i < edgeList.size(); i++){
            map = new ConcurrentHashMap<>();
            list = new ArrayList<>();
            Edge.RuntimeEdge edge = edgeList.get(i);
            edgeName = edge.getName().trim();
            sourceVertex = edge.getSourceVertex().getName().trim();
            targetVertex = edge.getTargetVertex().getName().trim();
            for(int j=0; j < edgeNameList.size(); j++){
                if((j != i) && edgeName.equalsIgnoreCase(edgeNameList.get(j))){
                    edgeName = edgeName + "_" + getFirstChars(sourceVertex) + vertexNumberMap.get(sourceVertex)
                            + "_" + getFirstChars(targetVertex) + vertexNumberMap.get(targetVertex);
                    break;
                }
            }
            elementNameList.add(edgeName);
            map.put("elementId", edge.getId().trim());
            map.put("stepNumberList", list);
            map.put("stepCount", Integer.parseInt("0"));
            map.put("sourceVertex", sourceVertex);
            map.put("targetVertex", targetVertex);
            elementMap.put(edgeName, map);
            TestLogOutputConfiguration.ModelDurationMap.put(edge.getId() + modelName, edgeName);
        }
        return elementNameList;
    }

    public String getFirstChars(String vertexName){

        StringBuilder firstChars = new StringBuilder();
        String[] array = vertexName.split("_");
        int startIndex = 0;

        if (array[0].equalsIgnoreCase("v")){
            startIndex = 1;
        }

        for (int i=startIndex; i < array.length; i++){

            firstChars.append(array[i].substring(0, 1).toUpperCase());
        }

        return firstChars.toString();
    }

    public void setBeforeElementData(Model.RuntimeModel model, Element element){

        int step = ++TestLogOutputConfiguration.stepCount;
        String currentTime = getTime("dd/MM/yyyy HH:mm:ss.SSS");
        String modelName = model.getName();
        String elementId = element.getId().trim();
        String modelElementName = element.getName().trim();
        String elementType = element instanceof Edge.RuntimeEdge ? "Edge" : "Vertex";

        if(TestLogOutputConfiguration.excelActive) {
            ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
            String elementName = TestLogOutputConfiguration.ModelDurationMap
                    .get(elementId + modelName).toString();
            map.put("modelName", modelName);
            map.put("elementName", elementName);
            map.put("currentTime", currentTime);
            map.put("Failure", "");
            TestLogOutputConfiguration.ModelDurationMap.put(String.valueOf(step), map);

            ConcurrentHashMap<String, Object> ElementMap = (ConcurrentHashMap<String, Object>) TestLogOutputConfiguration.ModelDurationMap.get(modelName);
            ConcurrentHashMap<String, Object> elementValuesMap = (ConcurrentHashMap<String, Object>) ElementMap.get(elementName);
            ((List<Integer>) elementValuesMap.get("stepNumberList")).add(step);
            elementValuesMap.put("stepCount", (Integer.parseInt(elementValuesMap.get("stepCount").toString()) + 1));
        }
        System.out.println("Test Step " + step + " : " + currentTime + "  " + modelName + "  "
                        + modelElementName + "  " + elementType
        );

    }

    public void setTestResult(String testResult){

        int step = ++TestLogOutputConfiguration.stepCount;
        String currentTime = getTime("dd/MM/yyyy HH:mm:ss.SSS");

        if (TestLogOutputConfiguration.excelActive) {
            ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
            map.put("modelName", "TEST_RESULT");
            map.put("elementName", "");
            map.put("currentTime", currentTime);
            map.put("Failure", testResult);
            TestLogOutputConfiguration.ModelDurationMap.put(String.valueOf(step), map);
            TestLogOutputConfiguration.ModelDurationMap.put("TotalStepCount", step);
        }
        System.out.println("Test Step " + step + " : " + currentTime + " " + "TEST_RESULT" + " " + testResult);

    }

    public void createExcel(){

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        List<String> modelList = new ArrayList<>();
        List<List<String>> testPathDurationsList = new ArrayList<>();
        List<List<String>> modelEntityVisitCountList = new ArrayList<>();
        List<String> pathlist;
        ConcurrentHashMap<Integer, String> timeMap = new ConcurrentHashMap<>();
        String previousModelName = "";
        String modelName;
        String currentModelName;
        String currentTime;
        String elementName;
        String currentElementName;
        int totalStepCount = Integer.parseInt(TestLogOutputConfiguration.ModelDurationMap.get("TotalStepCount").toString());
        for (int i=1; i < (totalStepCount+1); i++){
            pathlist = new ArrayList<>();
            ConcurrentHashMap<String, Object> stepMap = (ConcurrentHashMap<String, Object>) TestLogOutputConfiguration
                    .ModelDurationMap.get(String.valueOf(i));
            currentModelName = stepMap.get("modelName").toString();
            currentTime = stepMap.get("currentTime").toString();
            timeMap.put(i, currentTime);
            if(previousModelName.equals(currentModelName)){
                pathlist.add("");
                pathlist.add("");
            }else {
                pathlist.add(currentModelName);
                if(totalStepCount == i){
                    pathlist.add("");
                }else if(map.containsKey(currentModelName)){
                    int countModel = map.get(currentModelName) + 1;
                    pathlist.add(String.valueOf(countModel));
                    map.put(currentModelName, countModel);
                }else {
                    map.put(currentModelName , 1);
                    pathlist.add("1");
                    modelList.add(currentModelName);
                }
            }
            currentElementName = stepMap.get("elementName").toString();
            pathlist.add(currentElementName);
            if(totalStepCount == i) {
                pathlist.add("");
            }else if(map.containsKey(currentModelName + currentElementName)){
                int countElement = map.get(currentModelName + currentElementName) + 1;
                pathlist.add(String.valueOf(countElement));
                map.put(currentModelName + currentElementName, countElement);
            }else {
                map.put(currentModelName + currentElementName, 1);
                pathlist.add("1");
            }
            pathlist.add(currentTime);
            pathlist.add(stepMap.get("Failure").toString());
            testPathDurationsList.add(pathlist);
            previousModelName = currentModelName;
        }

        List<String> timeList = getTimeList(timeMap);

        List<String> modelNameList = (List<String>) TestLogOutputConfiguration.ModelDurationMap.get("ModelNameList");
        List<String> visitList;
        List<String> modelTotalTime;
        List<String> totalTime = new ArrayList<>();
        String elementTime;
        List<String> newModelList = new ArrayList<>(modelNameList);
        if(modelList.size() == 0){
            modelList.addAll(modelNameList);
        }else if(modelList.size() != modelNameList.size()) {
            for (String model : modelList) {
                newModelList.remove(model);
            }
            modelList.addAll(newModelList);
        }

        int modelListSize = modelList.size();
        for (int i=0; i < modelNameList.size(); i++) {

            modelTotalTime = new ArrayList<>();
            modelName = modelList.get(i);
            ConcurrentHashMap<String, Object> modelMap = (ConcurrentHashMap<String, Object>) TestLogOutputConfiguration
                    .ModelDurationMap.get(modelName);
            List<String> list = (List<String>) modelMap.get("vertexNameList");
            List<String> edgeNameList = (List<String>) modelMap.get("edgeNameList");
            list.addAll(edgeNameList);
            for(int j=0; j < list.size(); j++){
                visitList = new ArrayList<>();
                if(j==0){
                    visitList.add((i+1) + "/" + modelListSize);
                    visitList.add(modelName);
                }else {
                    visitList.add("");
                    visitList.add("");
                }
                elementName = list.get(j);
                visitList.add(elementName);
                ConcurrentHashMap<String, Object> elementMap = (ConcurrentHashMap<String, Object>) modelMap.get(elementName);
                List<Integer> stepNumberList = (List<Integer>) elementMap.get("stepNumberList");
                int stepCount = Integer.parseInt(elementMap.get("stepCount").toString());
                //System.out.println(modelName + "  " + elementName + "  " + stepCount + "  " +stepNumberList.toString());
                visitList.add(String.valueOf(stepCount));
                if((j+1) == list.size()){
                    visitList.add("true");
                }else {
                    visitList.add("");
                }
                elementTime = stepCount == 0 ? "00:00:00.000": getElementTotalTime(timeList, stepNumberList);
                modelTotalTime.add(elementTime);
                visitList.add(elementTime);
                if((j+1) == list.size()){
                    totalTime.add(getSumTimeWithHour(modelTotalTime));
                    visitList.add(totalTime.get(i));
                }else {
                    visitList.add("");
                }
                modelEntityVisitCountList.add(visitList);
            }
        }

        new CreateMBTExcel().createExcel(testPathDurationsList, modelEntityVisitCountList, getSumTimeWithHour(totalTime), timeList, modelList);
    }

    public String getElementTotalTime(List<String> timeList, List<Integer> stepNumberList){

        List<String> elementTimeList = new ArrayList<>();
        for (Integer integer : stepNumberList) {
            elementTimeList.add(timeList.get(integer - 1));
        }
        if(elementTimeList.size() == 1){
            return "00:" + elementTimeList.get(0);
        } else
            return getSumTime(elementTimeList);
    }

    public List<String> getTimeList(ConcurrentHashMap<Integer, String> timeMap){

        List<String> timeList = new ArrayList<>();
        for (int i=1; i < timeMap.size(); i++){
            timeList.add(getDifferenceTime(timeMap.get(i), timeMap.get(i+1)));
        }
        return timeList;
    }

    public String getTime(String format){

        return DateTime.now()//.withZone(DateTimeZone.UTC)
                .toString(format);//"dd/MM/yyyy HH:mm:ss,SSS");
    }

    public String getDifferenceTime(String before, String after){

        PeriodFormatter parser =
                new PeriodFormatterBuilder()
                        .appendDays().appendLiteral("/")
                        .appendMonths().appendLiteral("/")
                        .appendYears().appendLiteral(" ")
                        .appendHours().appendLiteral(":")
                        .appendMinutes().appendLiteral(":")
                        .appendSeconds().appendLiteral(".")
                        .appendMillis3Digit().toFormatter();
        Period period = Period.ZERO;
        period = period.plus(parser.parsePeriod(after)).minus(parser.parsePeriod(before));
        PeriodFormatter printer =
                new PeriodFormatterBuilder()
                        .printZeroAlways().minimumPrintedDigits(2)
                        .appendMinutes().appendLiteral(":")
                        .appendSeconds().appendLiteral(".")
                        .appendMillis3Digit().toFormatter();
        return printer.print(period.normalizedStandard());
    }

    public String getDifferenceTimeWithHour(String before, String after){

        PeriodFormatter parser =
                new PeriodFormatterBuilder()
                        .appendDays().appendLiteral("/")
                        .appendMonths().appendLiteral("/")
                        .appendYears().appendLiteral(" ")
                        .appendHours().appendLiteral(":")
                        .appendMinutes().appendLiteral(":")
                        .appendSeconds().appendLiteral(".")
                        .appendMillis3Digit().toFormatter();
        Period period = Period.ZERO;
        period = period.plus(parser.parsePeriod(after)).minus(parser.parsePeriod(before));
        PeriodFormatter printer =
                new PeriodFormatterBuilder()
                        .printZeroAlways().minimumPrintedDigits(2)
                        .appendHours().appendLiteral(":")
                        .appendMinutes().appendLiteral(":")
                        .appendSeconds().appendLiteral(".")
                        .appendMillis3Digit().toFormatter();
        return printer.print(period.normalizedStandard());
    }

    public String getSumTime(List<String> timeList){

        PeriodFormatter parser =
                new PeriodFormatterBuilder()
                        .appendMinutes().appendLiteral(":")
                        .appendSeconds().appendLiteral(".")
                        .appendMillis3Digit().toFormatter();
        Period period = Period.ZERO;
        for (String s : timeList) {
            period = period.plus(parser.parsePeriod(s));
        }
        PeriodFormatter printer =
                new PeriodFormatterBuilder()
                        .printZeroAlways().minimumPrintedDigits(2)
                        .appendHours().appendLiteral(":")
                        .appendMinutes().appendLiteral(":")
                        .appendSeconds().appendLiteral(".")
                        .appendMillis3Digit().toFormatter();
        return printer.print(period.normalizedStandard());
    }

    public String getSumTimeWithHour(List<String> timeList){

        PeriodFormatter parser =
                new PeriodFormatterBuilder()
                        .appendHours().appendLiteral(":")
                        .appendMinutes().appendLiteral(":")
                        .appendSeconds().appendLiteral(".")
                        .appendMillis3Digit().toFormatter();
        Period period = Period.ZERO;
        for (String s : timeList) {
            period = period.plus(parser.parsePeriod(s));
        }
        PeriodFormatter printer =
                new PeriodFormatterBuilder()
                        .printZeroAlways().minimumPrintedDigits(2)
                        .appendHours().appendLiteral(":")
                        .appendMinutes().appendLiteral(":")
                        .appendSeconds().appendLiteral(".")
                        .appendMillis3Digit().toFormatter();
        return printer.print(period.normalizedStandard());
    }

}
