package monster;

public class Monster {
    private String name;
    public Monster(){}
    public void setName(String name){
        this.name = name;
    }
    public  String getName(){
        return this.name;
    }
    public void attack(){
        System.out.println("Monster attack!");
    }
}
