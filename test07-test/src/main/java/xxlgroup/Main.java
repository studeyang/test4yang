package xxlgroup;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();

        Map<String, List<String>> user2JobId = main.getUser2JobId();
        List<JobInfo> jobInfos = main.getJobInfo();

        for (JobInfo jobInfo : jobInfos) {

            for (Map.Entry<String, List<String>> entry : user2JobId.entrySet()) {
                String group = entry.getKey();
                List<String> idList = entry.getValue();

                if (idList.contains(jobInfo.getId())) {
                    jobInfo.setGroup(group);
                }
            }
        }

        for (JobInfo jobInfo : jobInfos) {
            System.out.println(jobInfo.getGroup());
        }
    }

    public List<JobInfo> getJobInfo() {

        LinkedList<JobInfo> linkedList = new LinkedList<>();

        String meteData = "13,13,69,36,36,36,44,44,71,5,5,5,5,5,5,5,17,32,32,24,24,24,24,24,24,24,24,6,6,6,6,6,6,45,45,45,45,31,31,31,29,29,29,29,29,29,29,29,48,43,43,43,43,43,43,43,43,43,43,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,41,41,41,18,18,18,62,14,14,14,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,70,70,70,70,70,70,30,30,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,15,15,15,15,11,11,11,21,21,21,21,21,21,21,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,37,35,58,58,47,47,47,47,54,54,54,54,54,54,54,54,54,54,54,54,42,42,42,42,42,42,42,42,42,67,55,55,55,55,55,2,2,2,2,2,2,26,26,26,22,22,22,22,28,28,28,28,28,46,46,46,46,46,46,51,51,27,27,27,27,27,27,60,60,60,60,60,60,60,60,60,64,64,64,63,63,63,63,63,57,57,52,23,23,68,53,56,56,50,50,50";
        for (String id : meteData.split(",")) {

            JobInfo jobInfo = new JobInfo(id, "");

            linkedList.add(jobInfo);
        }

        return linkedList;
    }

    public Map<String, List<String>> getUser2JobId() {

        Map<String, List<String>> map = new HashMap<>();

        map.put("infra", Arrays.asList("39,45".split(",")));
        map.put("inquiry", Arrays.asList("18,23,29,31,36,41,27,62,67".split(",")));
        map.put("vipx", Arrays.asList("50,6,7,8,12,9,25,54,48".split(",")));
        map.put("order", Arrays.asList("2,17,44,49,55,59,34,66".split(",")));
        map.put("omgx", Arrays.asList("13,51,56,68,69,46".split(",")));
        map.put("mdmx", Arrays.asList("31,51,47".split(",")));
        map.put("finance", Arrays.asList("5,22,24,26,28,32,35,43,52,57,60,63,64,71,33".split(",")));
        map.put("sjfw", Arrays.asList("30,11,16,14,38,15,20,19,40,70,37,58,42,21".split(",")));

        return map;
    }

}
