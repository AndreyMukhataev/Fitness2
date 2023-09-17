import java.io.*;
import java.util.LinkedList;

public class JavaProject {
    public static void main(String[] args) {
        String mem;
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh= new FileHandler();
        LinkedList<Member> members = fh.readFile();
        int choice =0;

        while (choice!=-1) {
            choice = mm.getChoice();
            switch (choice) {
                case 1:
                    mem = mm.addMembers(members);
                    fh.appendFile(mem);
                    break;
                case 2:
                    mm.removeMember(members);
                    fh.overwriteFile(members);
                    break;
                case 3:
                    mm.printMemberInfo(members);
                    break;
            }
        }


//        LinkedList <Member> members= new LinkedList<>();
//        Member member= new SingleClubMember('S',0,"Андрей",900.0,1);
//        members.add(member);
//        member = new MultiClubMember('M',1,"Alex",-1.0,100);
//        members.add(member);
//
//        for (Member el: members) {
//            System.out.println(el.toString());
//            System.out.println(el.getClass());
//        }
    }
}