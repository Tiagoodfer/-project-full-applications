INSERT INTO client (uuid, name, email) VALUES
('8b1445e5-fb1a-49f3-978a-179e727a7f66', 'John Doe', 'john.doe@example.com'),
('440f00d7-c7c4-47da-911f-c93ebe6757a1', 'Jane Smith', 'jane.smith@example.com'),
('dba880d5-3c20-4d14-bab4-8dbd55916875', 'Alice Johnson', 'alice.johnson@example.com'),
('d4e37bd1-358f-41cd-969b-b3bcb4125c9e', 'Chris Lee', 'chris.lee@example.com'),
('e6cf6d7b-bfe1-4177-8442-8f9b98367d00', 'Pat Taylor', 'pat.taylor@example.com')
ON CONFLICT DO NOTHING;

INSERT INTO book (uuid, name, description) VALUES
('1e7f4d60-3d4e-4a65-9b49-4a97d7a5f905', 'O Grande Gatsby', 'Um romance escrito pelo autor americano F. Scott Fitzgerald.'),
('2c4b4a75-8a11-4b9c-bb5b-78a98b8b5967', 'Moby Dick', 'Um romance de Herman Melville sobre a busca obsessiva de um capitão por uma baleia branca.'),
('3f53df17-5b7e-4a89-b1d2-289d5e9290a2', '1984', 'Um romance distópico de George Orwell que trata de um regime totalitário.'),
('4d2a1f65-958b-4a9b-a14c-919b0b3a8d1e', 'O Sol é para Todos', 'Um romance de Harper Lee sobre injustiça racial nos EUA.'),
('5b9d2f60-2c8e-46e8-a8a8-9c2b3a6f4bb4', 'Orgulho e Preconceito', 'Um romance de Jane Austen que explora questões de classe, moralidade e casamento.'),
('6f79d1a3-1b5d-4e9b-8aa3-619b8b9f0c5a', 'O Apanhador no Campo de Centeio', 'Um romance de J.D. Salinger sobre a alienação e angústia juvenil.'),
('7c8d4b31-912b-4b9b-888b-b3f2a5c89c7b', 'O Senhor dos Anéis', 'Uma obra de fantasia épica escrita por J.R.R. Tolkien.'),
('8b2f0d19-5d6d-4b5d-84b1-56b3b4c5a93b', 'O Hobbit', 'Um livro de fantasia infantil de J.R.R. Tolkien que precede "O Senhor dos Anéis".'),
('9f4d7e62-6c91-4a9b-9a8b-8b4b8c0d6c9a', 'Guerra e Paz', 'Um extenso romance de Liev Tolstói que retrata a invasão napoleônica na Rússia.'),
('af5d2a98-8d75-4b9c-8b4b-6b7e9c1d5e4f', 'Crime e Castigo', 'Um romance de Fiódor Dostoiévski que explora temas de moralidade e arrependimento.')
ON CONFLICT DO NOTHING;

INSERT INTO booking (uuid, client_id, book_id) VALUES
('1a7f4d60-3d4e-4a65-9b49-4a97d7a5f911', '8b1445e5-fb1a-49f3-978a-179e727a7f66', '1e7f4d60-3d4e-4a65-9b49-4a97d7a5f905')
ON CONFLICT DO NOTHING;
