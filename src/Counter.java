import java.io.Serializable;

public class Counter implements Serializable {
  private int value = 0;
  //Метод инкрементирует счетчик
  void inc(){
      value++;
      System.out.println("Счеткчик увеличен на 1");
      statusValue();
  }
  //Метод показывает текущее значение счетчика и текст
   void statusValue() {
       System.out.println("Счетчик равен " + value);
   }
   //Метод возвращает значение счетчика
   int getValue(){
      return value;
   }
   //Метод сбрасывает счетчик до 0
   void reset(){
      this.value = 0;
       System.out.println("Счетчик сброшен до 0");
  }
}
