import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        int intWert = 0;
        double doubleWert = 0;

        try {
            System.out.print(Integer.parseInt(JOptionPane.showInputDialog("Please enter the number:")));
        }
        catch (NumberFormatException e){
            System.out.println("Data entry canceled");
            System.out.println(e);
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
}