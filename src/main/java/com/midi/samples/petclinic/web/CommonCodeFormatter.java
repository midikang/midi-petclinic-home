package com.midi.samples.petclinic.web;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import com.midi.samples.petclinic.model.CommonCode;
import com.midi.samples.petclinic.service.YfsService;

public class CommonCodeFormatter implements Formatter<CommonCode> {

	private final YfsService yfsService;
	
	@Autowired
	public CommonCodeFormatter(YfsService yfsService) {
		this.yfsService = yfsService;
	}

	@Override
	public String print(CommonCode commonCode, Locale locale) {
		return commonCode.getCodeValue();
	}

	@Override
	public CommonCode parse(String text, Locale locale) throws ParseException {
		// TODO hardcode to query "enterprise" commonCode
		Collection<CommonCode> commonCodes = this.yfsService.findCommonCodeByCodeType("enterprise");
		for (CommonCode commonCode :  commonCodes) {
			if (commonCode.getCodeValue().equals(text)) {
				return commonCode;
			}
		}
		throw new ParseException("common code not found", 0);
	}

}
