public class c{
    public static void main(String[] args){
        String str = "KMITL MI TECHASITMI";
        String[] temp = str.split(" ");
        String[] resultArray = new String[temp.length * 2];
          int resultIndex = 0;

        for(int i = 0; i < temp.length - 1; i++)
        {
            if(temp[i].equals("M") && temp[i+1].equals("I")){
                resultArray[resultIndex++] = "CSP";
                  i++;
                break;
            }
            System.out.println(temp);
        }
    }

}