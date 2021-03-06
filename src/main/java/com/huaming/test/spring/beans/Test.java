/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huaming.test.spring.beans;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


/**
 * 
 * @author Administrator
 * @since 4.3
 */
public class Test {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("selfdefinition.xml"));
		User user = (User) beanFactory.getBean("testBean");
		System.out.println(user.getUserName()+" "+user.getEmail());
		
	}
}
