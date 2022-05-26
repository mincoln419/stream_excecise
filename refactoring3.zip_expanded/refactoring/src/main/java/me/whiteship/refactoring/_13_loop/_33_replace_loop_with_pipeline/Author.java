package me.whiteship.refactoring._13_loop._33_replace_loop_with_pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Author {

    private String company;

    private String twitterHandle;

    public Author(String company, String twitterHandle) {
        this.company = company;
        this.twitterHandle = twitterHandle;
    }

    static public List<String> TwitterHandles(List<Author> authors, String company) {
    	List<String> result1 = getResultByAsis(authors, company);
    	List<String> result2 = getResultByStream(authors, company);
        
        return result2;
    }

	private static List<String> getResultByAsis(List<Author> authors, String company) {
		var result = new ArrayList<String> ();
        for (Author a : authors) {
            if (a.company.equals(company)) {
                var handle = a.twitterHandle;
                if (handle != null)
                    result.add(handle);
            }
        }
		return result;
	}

	private static List<String> getResultByStream(List<Author> authors, String company) {
		var result = authors.stream()
        	.filter(a -> a.company.equals(company))
        	.map(a -> a.twitterHandle)
        	.filter(Objects::nonNull)
        	.collect(Collectors.toList());
        return result;
	}

}
