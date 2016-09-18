package bbjs.practice.object;

import org.dom4j.Element;

public class JobElement implements Comparable<JobElement> {
	private String jobName;
	private Element jobNode;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Element getJobNode() {
		return jobNode;
	}

	public void setJobNode(Element jobNode) {
		this.jobNode = jobNode;
	}

	@Override
	public String toString() {
		return "JobElement [jobName=" + jobName + ", jobNode=" + jobNode + "]";
	}

	@Override
	public int compareTo(JobElement o) {
		// TODO Auto-generated method stub
		return this.jobName.compareTo(o.getJobName());
	}
	

}
