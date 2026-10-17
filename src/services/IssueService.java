package services;

import java.util.ArrayList;
import models.Issue;
import models.IssueStatus;

public class IssueService {

    private ArrayList<Issue> issues = new ArrayList<>();

    public void addIssue(Issue issue) {
        issues.add(issue);
        System.out.println("Issue reported successfully!");
    }

    public ArrayList<Issue> getAllIssues() {
        return issues;
    }

    public ArrayList<Issue> getIssuesByUser(int userId) {

        ArrayList<Issue> userIssues = new ArrayList<>();

        for (Issue issue : issues) {
            if (issue.getReportedBy() == userId) {
                userIssues.add(issue);
            }
        }

        return userIssues;
    }

    public Issue findIssueById(int issueId) {

        for (Issue issue : issues) {
            if (issue.getIssueId() == issueId) {
                return issue;
            }
        }

        return null;
    }

    public ArrayList<Issue> searchIssues(String keyword) {

        ArrayList<Issue> results = new ArrayList<>();

        for (Issue issue : issues) {

            if (issue.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || issue.getCategory().toLowerCase().contains(keyword.toLowerCase())) {

                results.add(issue);
            }
        }

        return results;
    }

    public boolean updateIssueStatus(int issueId, IssueStatus newStatus) {

        Issue issue = findIssueById(issueId);

        if (issue != null) {
            issue.setStatus(newStatus);
            return true;
        }

        return false;
    }
}