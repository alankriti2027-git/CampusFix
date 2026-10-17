package models;

public class Issue {

    private int issueId;
    private String title;
    private String description;
    private String category;
    private String location;
    private IssueStatus status;
    private int reportedBy;

    public Issue(int issueId, String title, String description,
                 String category, String location, int reportedBy) {

        this.issueId = issueId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.location = location;
        this.reportedBy = reportedBy;
        this.status = IssueStatus.OPEN;
    }

    public int getIssueId() {
        return issueId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public int getReportedBy() {
        return reportedBy;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public void displayIssue() {
        System.out.println("Issue ID: " + issueId);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Category: " + category);
        System.out.println("Location: " + location);
        System.out.println("Reported By: " + reportedBy);
        System.out.println("Status: " + status);
        System.out.println("-----------------------------");
    }
}