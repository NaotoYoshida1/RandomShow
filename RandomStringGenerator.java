package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class RandomStringGenerator {
	private final static int GENERATE_NUM = 10;

	public List<String> generate(int charLength, boolean withNumber, final int count, boolean withLanguage) {
		List<String> list = new ArrayList<>();
		//英字か数字かの判別
		if (withLanguage) {
			//英字の場合
			for (int i = 0; i < count; i++) {
				if (withNumber) {
					//英数字
					list.add(RandomStringUtils.randomAlphanumeric(charLength));
				} else {
					//英字のみ
					list.add(RandomStringUtils.randomAlphabetic(charLength));
				}
			}
		} else {
			//数字のみ
			for (int i = 0; i < count; i++) {
				list.add(RandomStringUtils.randomNumeric(charLength));
			}

		}
		return list;
	}
}
