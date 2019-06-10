package otherProblems;

import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        String simpPath = "/";
        String[] p = path.split("/");

        for(String c : p){

            if("..".equals( c)){
                stack.pop();
            }else if(".".equals(c) ||   "".equals(c)){
                continue;
            }else
            {
                stack.push(c);
            }

        }

        while(!stack.isEmpty()){
            simpPath+=stack.removeFirst()+"/";
        }

        return simpPath;
    }

    public static void main(String [] args){
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/a/./b/../../c/"));
    }
}
