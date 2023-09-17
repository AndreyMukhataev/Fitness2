import java.io.*;
import java.util.LinkedList;


public class FileHandler {
    public static final String FILENAME ="members.csv "; //наименование файла
    public static final String DELIMITER = ", ";  //Разделитель
    private static  final String TEMPFILENAME= "members.temp";  // Наименование временного файла
    //Чтение данных из CSV -файла с посетителями
    public LinkedList<Member>  readFile() {

        LinkedList<Member> memberLinkedList = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String s;
            Member member = null;
            memberLinkedList = new LinkedList<>();
            while ((s = reader.readLine()) != null) {
                String[] arrEl = s.split(DELIMITER);
                switch (arrEl[0]) {
                    case "S":
                        member = new SingleClubMember(arrEl[0].charAt(0), Integer.parseInt(arrEl[1]), arrEl[2], Double.parseDouble(arrEl[3]), Integer.parseInt(arrEl[4]));
                        break;
                    case "M":
                        member = new MultiClubMember(arrEl[0].charAt(0), Integer.parseInt(arrEl[1]), arrEl[2], Double.parseDouble(arrEl[3]), Integer.parseInt(arrEl[4]));
                        break;
                }
                memberLinkedList.add(member);
            }
            reader.close();
        } catch (IOException exp) {
            // exp.printStackTrace();
        }
        return memberLinkedList;
    }

    //Добавление новой строки в файл CSV
    public void appendFile(String mem){
        try(BufferedWriter writer = new BufferedWriter (new FileWriter(FILENAME,true)))
        {
            writer.append(mem);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Удаление посетителя из клуба. Файл будет перезаписан
    public void overwriteFile(LinkedList<Member> m){

        //Удаление предыдущего файла
        File deletedFile = new File(TEMPFILENAME);
        deletedFile.delete();

        try(BufferedWriter writer = new BufferedWriter (new FileWriter(TEMPFILENAME,true))) {
            for (Member elementList : m) {
                String mem = elementList.toStringWritefile();
                writer.write(mem);
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException exp){
            exp.printStackTrace();
        }
        //Удаление предыдущего файла
        deletedFile = new File(FILENAME);
        deletedFile.delete();

        //Переименование временного файла
        File renameFile = new File(TEMPFILENAME);
        renameFile.renameTo(deletedFile);

    }
}
