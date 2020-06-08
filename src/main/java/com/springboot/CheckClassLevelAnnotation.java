package com.springboot;

import org.springframework.stereotype.Component;

@Component
@ClassLevelAnnotation(value = "checkClassLevelAnnotation")
public class CheckClassLevelAnnotation {

	public boolean isValid() {
		return true;
	}
}