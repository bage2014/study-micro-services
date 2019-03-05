
INSERT INTO tb_route (
	id,
	path_pattern,
	service_id,
	url,
	strip_prefix,
	retryable,
	sensitive_headers,
	custom_sensitive_headers
)
VALUES
	(
		'0',
		'/client6/**',
		'cloud-client6',
		'',
		'true',
		'true',
		'',
		'false'
	);
