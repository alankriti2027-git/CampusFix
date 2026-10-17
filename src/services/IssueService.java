package services;

import java.util.ArrayList;
import models.Issue;
import models.IssueStatus;

public class IssueService {

    private ArrayList<Issue> issues = new ArrayList<>();
    private int nextIssueId = 1;

    public int generateIssueId() {
        return nextIssueId++;
    }

    public void addIssue(Issue issue) {

        if (issue == null) {
            System.out.println("Error: Issue cannot be null.");
            return;
        }

        if (issue.getTitle() == null || issue.getTitle().trim().isEmpty()) {
            System.out.println("Error: Issue title cannot be empty.");
            return;
        }

        if (issue.getDescription() == null || issue.getDescription().trim().isEmpty()) {
            System.out.println("Error: Issue description cannot be empty.");
            return;
        }

        if (issue.getLocation() == null || issue.getLocation().trim().isEmpty()) {
            System.out.println("Error: Issue location cannot be empty.");
            return;
        }

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

        if (keyword == null || keyword.trim().isEmpty()) {
            return results;
        }

        keyword = keyword.trim().toLowerCase();

        for (Issue issue : issues) {
            if (issue.getTitle().toLowerCase().contains(keyword)
                    || issue.getCategory().toLowerCase().contains(keyword)
                    || issue.getLocation().toLowerCase().contains(keyword)
                    || issue.getDescription().toLowerCase().contains(keyword)) {

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

    public ArrayList<Issue> getIssuesByStatus(IssueStatus status) {
        ArrayList<Issue> filteredIssues = new ArrayList<>();

        for (Issue issue : issues) {
            if (issue.getStatus() == status) {
                filteredIssues.add(issue);
            }
        }

        return filteredIssues;
    }
}