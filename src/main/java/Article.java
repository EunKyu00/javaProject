public class Article {
    int id;
    String subject;
    String content;
    Article(int id, String subject, String content){
        this.id = id;
        this.subject = subject;
        this.content = content;
    }
    int getId(){
        return this.id;
    }
    String getSubject(){
        return this.subject;
    }
    String getContent(){
        return this.content;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public void setContent(String content){
        this.content = content;
    }

}
