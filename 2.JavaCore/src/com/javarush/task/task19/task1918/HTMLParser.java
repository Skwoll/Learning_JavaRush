package com.javarush.task.task19.task1918;

import java.util.ArrayList;
import java.util.List;

public class HTMLParser {



    public static List<String> ParseHTMLTag (String tag,String file){
        String openTag = "<"+tag;
        String closeTag = "</"+tag+">";
        List<Integer> openTags = new ArrayList<Integer>();
        List<Integer> closeTags = new ArrayList<Integer>();
        int lastOpenTagIndex = 0;
        int lastCloseTagIndex = 0;

        while (lastCloseTagIndex >=0 && lastOpenTagIndex>=0)
        {
            lastOpenTagIndex = lastOpenTagIndex == -1 ? -1 : file.indexOf(openTag,lastOpenTagIndex);
            lastCloseTagIndex = lastCloseTagIndex == -1 ? -1 : file.indexOf(closeTag,lastCloseTagIndex);
            if (lastOpenTagIndex != -1){
                openTags.add(lastOpenTagIndex);
                lastOpenTagIndex++;
            }
            if (lastCloseTagIndex != -1){
                closeTags.add(lastCloseTagIndex);
                lastCloseTagIndex++;
            }
        }

        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < openTags.size() ; i++) {
            int curClose = 0;
            int curOpen = openTags.get(i);

            for (int j = 0; j < closeTags.size(); j++) {
                if (closeTags.get(j)> curOpen){
                    curClose = j;
                    break;
                }
            }

            int offOpen = i+1 < openTags.size() ? 1 : 0;
            int offClose = 0;
            int openCnt = 1;
            int closeCnt = 1;

            while(true){

                if (openCnt > openTags.size() || closeCnt > closeTags.size()) {
                    break;
                }

                if ((openTags.get(i+offOpen) > closeTags.get(curClose+offClose) || i+offOpen + 1 >= openTags.size() )
                        && openCnt == closeCnt){
                    pairs.add(new Pair(curOpen,closeTags.get(curClose+offClose)+closeTag.length()));
//                    curClose +=offClose+1;
                    break;
                } else{
                    if (openTags.get(i+offOpen)< closeTags.get(curClose+offClose)){
                        offOpen += i+offOpen+1 >= openTags.size() ? 0 : 1;
                        openCnt++;
                    }
                    else {
                        offClose += curClose+offClose+1 >= openTags.size() ? 0 :1;
                        closeCnt++;
                    }

                }

            }
        }

        List<String> result = new ArrayList<>();

        for (Pair p :
                pairs) {
            result.add(file.substring((Integer) p.t, (Integer) p.u));
        }

        return result;
    }

}
