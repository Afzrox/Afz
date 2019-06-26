class DecimalToBinary{
    public static void Binary(int Num){
        String orignal="";
        int reminder,i;
        String reverse="";
        while(Num>0){
            reminder=Num%2;
            Num=Num/2;
            //System.out.print(reminder);
            //orignal=(orignal*10)+reminder;
            //count++;
            // Binary(Num);
            orignal=orignal+reminder;
        }
        int length = 8-orignal.length();
        if(length>0){
           for(i=0;i<length;i++){
                orignal=orignal+0;
            }
        }
        System.out.println("Orignal is :"+orignal);
        for(i=orignal.length()-1;i>=0;i--){
            if(i==(orignal.length()/2)-1){
                reverse=reverse+" ";
            }
            reverse=reverse+orignal.charAt(i);
        }
        System.out.println("Reverse is :"+reverse);

    }
    public static void main(String[] args) {
        int Num=120;
        Binary(Num);
    }
}