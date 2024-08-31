import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;
    List<Article> articleList = new ArrayList<>();
    App(Scanner sc){
        this.sc = sc;
    }
    public void run(){
        int lastId = 1;
        System.out.println("== 게시판 앱 ==");

        while (true){
            System.out.print("명령 ) ");
            String command = sc.nextLine();

            if (command.equals("종료")){
                break;
            }else if(command.equals("등록")){
                System.out.print("제목 : ");
                String subject = sc.nextLine();
                System.out.print("내용 : ");
                String content = sc.nextLine();
                System.out.printf("%d번 게시글이 등록되었습니다.\n", lastId);
                Article article = new Article(lastId, subject, content);
                articleList.add(article);

                lastId ++;
            }else if(command.equals("목록")){
                System.out.println("번호 / 제목 / 내용");
                System.out.println("-----------------");
                for(int i = 0 ; i < articleList.size(); i++){
                  Article article = articleList.get(i);
                    System.out.printf("%d / %s / %s\n", article.getId(), article.getSubject(), article.getContent());
                }
            }else if(command.startsWith("삭제")){
                String[] commandList = command.split("\\?", 2);
                String actionCode = commandList[0];
                String[] Str = commandList[1].split("=", 2);
                String key = Str[0];
                String value = Str[1];
                int index = Integer.parseInt(value);

                Article article = _getFindById(index);

                if(article == null){
                    System.out.printf("%d번 게시글이 존재하지 않습니다.\n", index);
                }else{
                    articleList.remove(article);
                    System.out.printf("%d번 게시글이 삭제되었습니다.\n", index);
                }
            }else if(command.startsWith("수정")){
                String[] commandList = command.split("\\?", 2);
                String actionCode = commandList[0];
                String[] Str = commandList[1].split("=", 2);
                String key = Str[0];
                String value = Str[1];
                int index = Integer.parseInt(value);

                Article article = _getFindById(index);

                if(article == null){
                    System.out.printf("%d번 게시글이 존재하지 않습니다.\n", index);
                }else {
                    System.out.printf("기존 제목 : %s\n", article.getSubject());
                    System.out.print("제목 입력 : ");
                    String modifySubject = sc.nextLine();
                    article.setSubject(modifySubject);

                    System.out.printf("기존 내용 : %s\n", article.getContent());
                    System.out.print("내용 입력 : ");
                    String modifyContent = sc.nextLine();
                    article.setContent(modifyContent);
                    System.out.println("== 수정 완료 ==");
                }
            }
        }
    }
    private Article _getFindById(int id){
        for(Article item : articleList){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }
}
