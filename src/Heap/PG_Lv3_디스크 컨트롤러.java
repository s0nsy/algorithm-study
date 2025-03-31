import java.util.*;
//+10점
class Solution{
   public int solution(int[][] jobs) {
      int answer = 0;
      PriorityQueue<Job> pq = new PriorityQueue<>(
            new Comparator<Job>(){
               @Override
               public int compare(Job o1, Job o2){
                  // 소요시간 오름차순
                  if(o1.lead==o2.lead){ // 요청 시각 오름차순
                     if(o1.request== o2.request)
                        return o1.num-o2.num; //번호 오름차순
                     else return o1.request- o2.request;
                  }else return o1.lead-o2.lead;
               }
            });

      Arrays.sort(jobs,(a,b)->a[0]-b[0]);

      int jobIndex=0;
      int time=0;
      int jobCompleted=0;
      while(jobCompleted<jobs.length){
         // pq에 job 추가
         while(jobIndex<jobs.length&&time>=jobs[jobIndex][0]){
            pq.add(new Job(jobs[jobIndex][1],jobs[jobIndex][0],jobIndex));
            jobIndex++;
         }
         if(!pq.isEmpty()){
            Job job = pq.poll();
            // 소요시간만큼 지남
            time+=job.lead;
            answer+=time-job.request;
            jobCompleted++;
         }else{ //해당 시간에 할 일이 없는 경우
            time=jobs[jobIndex][0];
         }
      }
      return answer/jobs.length;
   }

}
// 작업 소요시간이 짧거나, 요청 시간이 빠르거나, 번호가 작은 것  순
class Job {
   int lead;
   int request;
   int num;
   Job(int lead, int request, int num){
      this.lead=lead;
      this.request= request;
      this.num = num;
   }
}