package me.whiteship.refactoring._02_duplicated_code._04_extract_function;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StudyDashboard {

    private void printParticipants(int eventId) throws IOException {
        GHIssue issue = getGhIssue(eventId);
        Set<String> participants = getUsername(issue);
        print(participants);
    }

	private Set<String> getUsername(GHIssue issue) throws IOException {
		Set<String> usernames = new HashSet<>();
        issue.getComments().forEach(c -> usernames.add(c.getUserName()));
		return usernames;
	}

	private GHIssue getGhIssue(int eventId) throws IOException {
		GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(eventId);
		return issue;
	}

    private void printReviewers() throws IOException {
        Set<String> reviewers = getUsername(getGhIssue(30));
        print(reviewers);
    }

	private void print(Set<String> reviewers) {
		reviewers.forEach(System.out::println);
	}

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.printReviewers();
        studyDashboard.printParticipants(15);
    }

}
