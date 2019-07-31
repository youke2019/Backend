package com.yoke.backend.Service.SensitiveFilter;


import com.yoke.backend.Service.SensitiveFilter.FilterUtils.KWSeeker;
import com.yoke.backend.Service.SensitiveFilter.FilterUtils.KeyWord;
import com.yoke.backend.Service.SensitiveFilter.FilterUtils.SensitiveWordResult;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FilterService {

    private static FilterService filterService;
    private Set<KeyWord> keywords;
    private KWSeeker seeker;
    private Set<String> stops;

    private FilterService() throws Exception {
        String[] files = {"ads.txt", "erotic.txt", "outlaw.txt", "politic.txt", "website.txt"};
        keywords = new HashSet<>();
        stops = new HashSet<>();
        for (String file : files) {
            addSensitiveWord(readWordFromFile("sensitive/" + file), keywords);
        }
        seeker = new KWSeeker(keywords);
        addStopWord(readWordFromFile("sensitive/stop.txt"));

    }

    public static FilterService getInstance()  {
        try {
            if (filterService == null) {
                filterService = new FilterService();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return filterService;
    }

    public String filter(String src) {
        String rid = ridOfStops(src);
        List<SensitiveWordResult> wordResults = seeker.findWords(rid);
        if (wordResults.size() == 0) {
            return src;
        } else {
            String replace = seeker.replaceWords(src);
            return replace;
        }
    }

    private String ridOfStops(String src) {
        return src;
    }

    /**
     * 增加敏感词
     *
     * @param path
     * @return
     */
    private List<String> readWordFromFile(String path) throws Exception {
        List<String> words;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(FilterService.class.getClassLoader().getResourceAsStream(path)));
            words = new ArrayList<>(1024);
            for (String buf = ""; (buf = br.readLine()) != null; ) {
                if (buf == null || buf.trim().equals(""))
                    continue;
                words.add(buf);
            }
        } finally {
            if (br != null)
                br.close();
        }
        return words;
    }

    private void addSensitiveWord(List<String> words, Set<KeyWord> keyWordSet) {
        for (String word : words) {
            if (word.charAt(word.length() - 1) == ',') {
                word = word.substring(0, word.length() - 1);
            }
            keyWordSet.add(new KeyWord(word));
        }
    }

    private void addStopWord(List<String> words) {
        for (String word : words) {
            stops.add(word);
        }
    }

}
