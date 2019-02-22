--------------- H2 ---------------

drop table if exists tb_route;
create table tb_route (
  id VARCHAR(255) PRIMARY KEY,
  path_pattern VARCHAR(255),
  service_id VARCHAR(255),
  url VARCHAR(1024),
  strip_prefix VARCHAR(8),
  retryable VARCHAR(8),
  sensitive_headers VARCHAR(255),
  custom_sensitive_headers VARCHAR(8)
);