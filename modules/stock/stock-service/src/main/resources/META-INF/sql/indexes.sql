create index IX_E7873E52 on Softenger_Stock (groupId, status);
create index IX_A72F4572 on Softenger_Stock (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3A4E8074 on Softenger_Stock (uuid_[$COLUMN_LENGTH:75$], groupId);