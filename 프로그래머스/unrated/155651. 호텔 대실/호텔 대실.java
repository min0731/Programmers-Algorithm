import java.util.*;

class Book{
    int start,end;
        
    public Book(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int toMinute(String time){
        //14:00 형태로 오기에 : 기준으로 split 한 뒤 
        // 시간 앞에는 60을 곱해서 저장 
        String tmp [] = time.split(":"); // "14", "00" 이렇게 들어가 있음 
        int minute=Integer.parseInt(tmp[0])* 60 +  Integer.parseInt(tmp[1]);
        return minute;
    }
    
    List<Book> bookList = new ArrayList<Book>();
    
    public int solution(String[][] book_times) {
        for(String[] book_time : book_times){
            int start = toMinute(book_time[0]);
            int end = toMinute(book_time[1])+10; // 청소시간을 더하기 

            //시작시간과 끝나는 시간을 INTEGER로 변경하여 List에 넣음
            bookList.add(new Book(start,end));
        }
        
        // 시작 시간대로 정렬 -> Collection.sort(리스트 ,  (o1,o2) ->{ 내용 })
        Collections.sort(bookList,(o1,o2)->{
            if(o1.start==o2.start) return o1.end-o2.end;
            else return o1.start-o2.start;
        });

        // 필요한 방의 갯수를 파악하기 위함 -> 종료시간을 기준으로 
        List<Integer> rooms =new ArrayList<>();
        
        for (Book book: bookList){
            boolean isOk=false;
            
            //지금까지 생성된 방을 돌면서 -> 들어갈 수 있는 시간대가 있는지 파악
            for (int i=0; i<rooms.size();i++){
                int endTime = rooms.get(i);
                
                if (book.start >=endTime){
                    rooms.set(i,book.end); //끝나는 시간을 갱신 
                    isOk=true; //들어갈 수 있는 방이 있으니 true로 변경
                    break;
                }
            }
            if (!isOk) rooms.add(book.end);
        }
        return rooms.size();
    }
}