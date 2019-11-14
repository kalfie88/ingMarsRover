CREATE TABLE audit_nasa_calls (
    id  INTEGER      NOT NULL auto_increment,
    request_method_name VARCHAR(100),
    response_time  BIGINT,
    created_date DATE,
    PRIMARY KEY (id)
);