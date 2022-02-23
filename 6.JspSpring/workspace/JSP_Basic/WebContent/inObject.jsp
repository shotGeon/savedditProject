<%@page import="com.java.dto.MemberVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


applicationScope getAttribute : ${applicationScope.msg}
sessionScope getAttribute :${sessionScope.msg}
referenceType get: ${dataMap.girlGroup}
MemberVO get : ${member.id}

