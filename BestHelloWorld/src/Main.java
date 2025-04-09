public class Main {
    public static void main(String[] args) {

        greet();
    }

    public static void greet(){

        String greeting = "Hola mundo!";
        String show = "";
        for(char letra:greeting.toCharArray()){

            for(int j=0; j<10; j++) {
                for (int i = 32; i < 127; i++) {
                    char c = (char) i;
                    if(c == letra){
                        if(j==9){
                            show = show + c;
                            System.out.println(show);
                            break;
                        }
                    }else{
                        System.out.println(show+c);
                    }

                    try{
                        Thread.sleep(0,1);
                    }catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.flush();


                }
            }
        }

    }

}