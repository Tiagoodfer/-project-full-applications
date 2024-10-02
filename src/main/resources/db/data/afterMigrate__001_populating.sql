INSERT INTO client (uuid, name, email) VALUES
('8b1445e5-fb1a-49f3-978a-179e727a7f66', 'John Doe', 'john.doe@example.com'),
('440f00d7-c7c4-47da-911f-c93ebe6757a1', 'Jane Smith', 'jane.smith@example.com'),
('dba880d5-3c20-4d14-bab4-8dbd55916875', 'Alice Johnson', 'alice.johnson@example.com'),
('d4e37bd1-358f-41cd-969b-b3bcb4125c9e', 'Chris Lee', 'chris.lee@example.com'),
('e6cf6d7b-bfe1-4177-8442-8f9b98367d00', 'Pat Taylor', 'pat.taylor@example.com')
ON CONFLICT DO NOTHING;