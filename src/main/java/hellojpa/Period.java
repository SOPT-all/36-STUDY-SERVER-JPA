package hellojpa;

import java.time.LocalDateTime;

public class Period {

	// 기간 Period
	private LocalDateTime startDate;
	private LocalDateTime endDate;

	public Period(){

	}

	public Period(LocalDateTime startDate, LocalDateTime endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
}
