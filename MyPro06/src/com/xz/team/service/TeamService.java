package com.xz.team.service;

import com.xz.team.domain.Architect;
import com.xz.team.domain.Designer;
import com.xz.team.domain.Employee;
import com.xz.team.domain.Programmer;

public class TeamService {
	private static int counter = 1;//给memberId赋值用
	private final int MAX_MEMBER = 5;//限制开发团队的人数
	private Programmer[] team = new Programmer[5];//保存开发团队成员
	private int total;//开发团队中实际人数
	
	public TeamService() {
		super();
	}
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for(int i = 0; i < team.length; i++) {
			team[i] = this.team[i];
		}
		return team;
	}
	public void addMember(Employee e) throws TeamException {
		/*
		 * 成员已满无法添加
		 * 该成员不是开发人员，无法添加
		 * 该员工已在团队中
		 * 该员工已经是某团队成员
		 * 员工正在休假
		 * 最多一名架构师，两名设计师，三名程序员
		 */
		
		if(total >= MAX_MEMBER) {
			throw new TeamException("成员已满无法添加");
		}
		if(!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		if(isExist(e)) {
			throw new TeamException("该员工已在团队中");
		}
		Programmer programmer = (Programmer)e;//一定不会出现ClassCastException
//		if("BUSY".equalsIgnoreCase(programmer.getStatus().getNAME())) {//(programmer.getStatus().getNAME().equals("BUSY")) {
//			throw new TeamException("该员工已经是某团队成员");
//		}else if ("VACATION".equalsIgnoreCase(programmer.getStatus().getNAME())) {
//			throw new TeamException("员工正在休假");
//		}
		switch (programmer.getStatus()){
			case BUSY:
				throw new TeamException("该员工已经是某团队成员");
			case VACATION:
				throw new TeamException("员工正在休假");
		}
		int numOfArch = 0, numOfDes = 0, numOfPro = 0;
		for(int i = 0; i < total; i++) {
			if(team[i] instanceof Architect) {
				numOfArch++;
			}else if (team[i] instanceof Designer) {
				numOfDes++;
			}else if (team[i] instanceof Programmer) {
				numOfPro++;
			}
		}
//		if(programmer instanceof Architect && numOfArch > 1) {//两个条件写在一起，如果前面满足后面不满足，就会执行下面的判断
//			throw new TeamException("最多一名架构师");			//分开写就确保不会执行下面的判断
//		}else if (programmer instanceof Designer && numOfDes > 2) {
//			throw new TeamException("最多两名设计师");
//		}else if (programmer instanceof Designer && numOfPro > 3) {
//			throw new TeamException("最多三名程序员");
//		}
		if(programmer instanceof Architect) {
			if(numOfArch >= 1)
				throw new TeamException("最多一名架构师");			
		}else if (programmer instanceof Designer) {
			if(numOfDes >= 2)
				throw new TeamException("最多两名设计师");
		}else if (programmer instanceof Programmer) {
			if(numOfPro >= 3)
				throw new TeamException("最多三名程序员");
		}
		
		programmer.setStatus(Status.BUSY);
		programmer.setMemberId(counter++);
		team[total++] = programmer;
	}
	
	private boolean isExist(Employee e) {
		for(int i = 0; i < total; i++) {
			if(team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}
	public void removeMember(int memberId) throws TeamException {
		int i;
		for(i = 0; i < total; i++) {
			if(team[i].getMemberId() == memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		//删除后，最后一个置空
		if(i == total) {
			throw new TeamException("找不到指定memberId的员工，删除失败");
		}
		for(int j = i + 1; j < total; j++) {
			team[j - 1] = team[j];
		}
		team[--total] = null;
	}
}
