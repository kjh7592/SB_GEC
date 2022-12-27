package com.kjh.exam.gec.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ItemInformation {
	private String itemPart = "";
	private int count = 0;
	private boolean isOpChange = false;
	private String oT = "";
	private int size = 0;
	private String itemClass = "";
	private int upgrade = 15;
	
	int discount = 0; // 총 점수할인값
	int plusValidOp = -12; // 유효옵이 붙었을 때의 재련점수할인값
	int plusInValidOp = -9; // 무효옵이 붙었을 때의 재련점수할인값
	int discountAtUpg = -6; // 강화단계 3단계당 점수할인값
	int useOpChange = -6; // 변환석 사용시 점수할인값
	int gotItemLimit = 1; // 갓템의 기준을 높이기 위한 값
	int midStandardSupplement = 11; // 중수권 템 점수 기준에는 포함되지 않아야 하는 재련 점수를 보정하기 위한 값
	
	String[] kindOfUpgrade = {"0강", "3강", "6강", "9강", "12강", "15강", "재련"}; // (구현 예정)반복문을 이용해서 코드줄을 줄이기 위한 배열

//	List<ItIO> itios = new ArrayList<>();

	boolean isPlusOneInvalidOp = false;

	boolean isInValidOpBefore = false;
	boolean isInValidOpAfter = false;

	float totalSize = 0;
}
