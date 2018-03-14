package com.example.demo.mapping;

public class URLMapping {

	public static final String ACCOUNTS_API_V1 = "/v1";

	public static final String REGISTER = ACCOUNTS_API_V1 + "/register";
	public static final String VERIFICATION = ACCOUNTS_API_V1+"/verification";
	public static final String LOGIN = ACCOUNTS_API_V1+"/login";

	// Roles
	public static final String ADD_ROLE = ACCOUNTS_API_V1 + "/add_role";
	public static final String ACTIVATE_OR_DEACTIVATE_ROLE = ACCOUNTS_API_V1 + "/update_role";
	public static final String GET_ALL_ROLES = ACCOUNTS_API_V1 + "/roles";
	public static final String GET_ACTIVE_ROLES = ACCOUNTS_API_V1 + "/active_roles";
	public static final String GET_ROLE_BY_ID = ACCOUNTS_API_V1 + "/role/id";
	public static final String GET_ROLE_BY_NAME = ACCOUNTS_API_V1 + "/role/name";
	public static final String UPDATE_ROLE = ACCOUNTS_API_V1 + "/update_role";
	public static final String FETCH_ROLE = ACCOUNTS_API_V1 + "/role";
	public static final String DELETE_ROLE = ACCOUNTS_API_V1 + "/delete_role/{id}";

	// Activities
	public static final String ALL_ACTIVITIES = ACCOUNTS_API_V1 + "/all_activities";
	public static final String AUTHORIZED_ACTIVITIES = ACCOUNTS_API_V1 + "/activities";
	public static final String ASSIGN_ACTIVITIES = ACCOUNTS_API_V1 + "/assign_activities";
	public static final String ADD_ACTIVITY = ACCOUNTS_API_V1 + "/add_activity";
	public static final String GET_ACTIVITIES = ACCOUNTS_API_V1 + "/activities";
	public static final String DELETE_ACTIVITY = ACCOUNTS_API_V1 + "/delete_activity/{id}";
	public static final String UPDATE_ACTIVITY = ACCOUNTS_API_V1 + "/update_activity";
	
	//User
	public static final String ADD_USER = ACCOUNTS_API_V1 + "/add_user";
	public static final String GET_ALL = ACCOUNTS_API_V1 + "/get_all";
	public static final String DELETE_USER = ACCOUNTS_API_V1 + "/delete_user/{id}";
	public static final String UPDATE_USER = ACCOUNTS_API_V1 + "/update_user";
	public static final String FETCH_USER = ACCOUNTS_API_V1 + "/user/{id}";
	
	
	//Profile
	public static final String ADD_PROFILE = ACCOUNTS_API_V1 + "/add_profile";
	public static final String GET_ALL_PROFILE = ACCOUNTS_API_V1 + "/profiles";
	public static final String DELETE_PROFILE = ACCOUNTS_API_V1 + "/delete_profile/{id}";
	public static final String UPDATE_PROFILE = ACCOUNTS_API_V1 + "/update_profile";
	public static final String FETCH_PROFILE = ACCOUNTS_API_V1 + "/profile/{id}";
	
	//Book
	public static final String ADD_BOOK = ACCOUNTS_API_V1 + "/add_book";
	public static final String UPDATE_BOOK = ACCOUNTS_API_V1 + "/update_book";
	public static final String ALL_BOOKS = ACCOUNTS_API_V1 + "/all_books";
	public static final String DELETE_BOOK = ACCOUNTS_API_V1 + "/delete_book/{id}";
	public static final String FETCH_BOOK = ACCOUNTS_API_V1 + "/book/{id}";
	
	//Category
	public static final String ADD_CATEGORY = ACCOUNTS_API_V1 + "/add_category";
	public static final String UPDATE_CATEGORY = ACCOUNTS_API_V1 + "/update_category";
	private URLMapping() {
	}

}