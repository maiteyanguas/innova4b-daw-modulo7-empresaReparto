getI18nReady = function() {
	var cookie = $.cookie("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE");
	var lang = cookie === undefined ? 'es' : cookie;
	jQuery.i18n.properties({
		name : 'messages',
		path : '/messages/',
		mode : 'both',
		language : lang
	});
};
