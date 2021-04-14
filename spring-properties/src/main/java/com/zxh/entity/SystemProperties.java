package com.zxh.entity;


import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:app.properties"})
//@PropertySource({"classpath:app.properties","classpath:db.properties"})
public class SystemProperties {}
