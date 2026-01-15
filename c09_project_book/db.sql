create database if not exists project_c09_book_online;
use project_c09_book_online;

-- CATEGORY
-- =========================
CREATE TABLE category (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(50) NOT NULL,
                          isdeleted TINYINT(1) DEFAULT 0
);

-- =========================
-- TAG
-- =========================
CREATE TABLE tag (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     name VARCHAR(50) NOT NULL,
                     isdeleted TINYINT(1) DEFAULT 0
);

-- ACCOUNT
-- =========================
CREATE TABLE account (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         username VARCHAR(50) NOT NULL,
                         password VARCHAR(50) NOT NULL,
                         role ENUM('ADMIN','USER') NOT NULL,
                         isdeleted TINYINT(1) DEFAULT 0,
                         islocked TINYINT(1) DEFAULT 0
) ;

-- =========================
-- CUSTOMER
-- =========================
CREATE TABLE customer (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          id_account INT,
                          name VARCHAR(50),
                          phone VARCHAR(50),
                          email VARCHAR(50),
                          address VARCHAR(255),
                          isdeleted TINYINT(1) DEFAULT 0,
                          FOREIGN KEY (id_account) REFERENCES account(id)
) ENGINE=InnoDB;

-- =========================
-- BOOK
-- =========================
CREATE TABLE book (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(50) NOT NULL,
                      price DOUBLE,
                      stock INT,
                      `desc` LONGTEXT,
                      author VARCHAR(50),
                      image_url text,
                      id_category INT,
                      isdeleted TINYINT(1) DEFAULT 0,
                      FOREIGN KEY (id_category) REFERENCES category(id)
) ENGINE=InnoDB;

-- =========================
-- CHAPTER
-- =========================
CREATE TABLE chapter (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         id_book INT,
                         chapter_unlock INT,
                         point INT default 10,
                         isdeleted TINYINT(1) DEFAULT 0,
                         FOREIGN KEY (id_book) REFERENCES book(id)
) ENGINE=InnoDB;

-- =========================
-- ACCOUNT_CHAPTER
-- =========================
CREATE TABLE account_chapter (
                                 id_account INT,
                                 id_chapter INT,
                                 time DATE,
                                 point INT default 50,
                                 isdeleted TINYINT(1) DEFAULT 0,
                                 PRIMARY KEY (id_account, id_chapter),
                                 FOREIGN KEY (id_account) REFERENCES account(id),
                                 FOREIGN KEY (id_chapter) REFERENCES chapter(id)
) ENGINE=InnoDB;

-- =========================
-- BOOK_TAG
-- =========================
CREATE TABLE book_tag (
                          id_book INT,
                          id_tag INT,
                          isdeleted TINYINT(1) DEFAULT 0,
                          PRIMARY KEY (id_book, id_tag),
                          FOREIGN KEY (id_book) REFERENCES book(id),
                          FOREIGN KEY (id_tag) REFERENCES tag(id)
) ENGINE=InnoDB;

-- =========================
-- ORDER
-- =========================
CREATE TABLE `order` (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         id_customer INT,
                         status VARCHAR(50),
                         total INT,
                         time DATE,
                         isdeleted TINYINT(1) DEFAULT 0,
                         FOREIGN KEY (id_customer) REFERENCES customer(id)
) ENGINE=InnoDB;

-- =========================
-- ORDER_ITEM
-- =========================
CREATE TABLE order_item (
                            id_order INT,
                            id_book INT,
                            quantity INT,
                            price DOUBLE,
                            isdeleted TINYINT(1) DEFAULT 0,
                            PRIMARY KEY (id_order, id_book),
                            FOREIGN KEY (id_order) REFERENCES `order`(id),
                            FOREIGN KEY (id_book) REFERENCES book(id)
) ENGINE=InnoDB;

-- =========================
-- PAYMENT_TYPE
-- =========================
CREATE TABLE payment_type (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              name VARCHAR(50),
                              rate DECIMAL(20,6),
                              isdeleted TINYINT(1) DEFAULT 0
) ENGINE=InnoDB;

-- =========================
-- PAYMENT
-- =========================
CREATE TABLE payment (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         id_type INT,
                         id_order INT,
                         status VARCHAR(50),
                         isdeleted TINYINT(1) DEFAULT 0,
                         FOREIGN KEY (id_type) REFERENCES payment_type(id),
                         FOREIGN KEY (id_order) REFERENCES `order`(id)
) ENGINE=InnoDB;

-- =========================
-- ADD_POINT
-- =========================
CREATE TABLE change_point (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              id_account INT,
                              id_order INT,
                              point INT,
                              type ENUM('ADD','SUB') NOT NULL,
                              time DATE,
                              isdeleted TINYINT(1) DEFAULT 0,
                              FOREIGN KEY (id_account) REFERENCES account(id),
                              FOREIGN KEY (id_order) REFERENCES `order`(id)
) ENGINE=InnoDB;

-- Inset dữ liệu

INSERT INTO category (name) VALUES
                                ('Văn học'),
                                ('Tiểu thuyết'),
                                ('Truyện ngắn'),
                                ('Truyện tranh'),
                                ('Bút ký');

INSERT INTO tag (name) VALUES
                           ('Lịch sử'),
                           ('Kinh điển'),
                           ('Kiếm hiệp'),
                           ('Phiêu lưu'),
                           ('Tiên hiệp');

INSERT INTO book (name, price, stock, `desc`,author, id_category) VALUES
                                                                      ('Tam Quốc Diễn Nghĩa', 150000, 50, 'Cuối Hán mục nát, thiên hạ rạn nứt, anh hùng sắp bước ra.

Hán Linh Đế năm cuối, triều đình rệu rã, hoạn quan lộng quyền, chư hầu các nơi ngấm ngầm nuôi binh. Trên triều là lễ nhạc suy tàn, dưới dân gian là đói khát, loạn lạc, tiếng khóc lan khắp cửu châu.

Người ta thấy hào kiệt kết nghĩa nơi vườn đào, cũng thấy gian hùng giấu chí sau nụ cười. Trí mưu đối đầu trí mưu, đao kiếm chưa ra mà thiên hạ đã nghiêng ngả. Trung nghĩa và dã tâm cùng tồn tại, anh hùng và phản tặc chỉ cách nhau một bước.

Gió nổi từ cuối Hán, tam phân thiên hạ từ đây mà thành.', "La Quán Trung", 2),
                                                                      ('Tây Du Ký', 140000, 40, 'Hành trình thỉnh kinh đầy huyền ảo và triết lý nhân sinh.','Chanh trần', 2),
                                                                      ('Liễu Phàm Tứ Huấn',100000,20,'Đã sinh làm kiếp người, mỗi người chúng ta đều muốn có được một số mệnh tốt, đó là hai chữ phúc lộc.
Chẳng những thế lại còn muốn có thêm chữ thọ nữa.
Lòng người thì ước như vậy, nhưng trời có tuân theo lòng người chăng?',"Long Nhật",2),
                                                                      ('Đạo Quỷ Dị Tiên',200000,30, 'Thiên địa vốn chính, nhưng đạo không chỉ một đường. Có người tu
tiên cầu trường sinh, có kẻ nhập quỷ tìm sức mạnh, giữa ranh giới sáng – tối sinh ra con đường quỷ dị, Tiên hay quỷ, chính hay tà, rốt
cuộc chỉ là cách người đời gọi tên kẻ sống sót đến cuối con đường.','Hải TT',3),
                                                                      ('Hồng Lâu Mộng', 160000, 30, 'Bi kịch tình yêu và suy tàn của một gia tộc phong kiến.', 'Nguyễn Ánh', 1),
                                                                      ('Thủy Hử', 145000, 35, 'Câu chuyện anh hùng nghĩa khí thời loạn thế.', 'Quang Trung', 2),
                                                                      ('Anh Hùng Xạ Điêu', 170000, 45, 'Kiếm hiệp kinh điển với tinh thần chính nghĩa.', 'Quang Trung', 2),
                                                                      ('Thần Điêu Đại Hiệp', 175000, 40, 'Chuyện tình bi tráng giữa Dương Quá và Tiểu Long Nữ.', 'Quang Trung', 5),
                                                                      ('Tiếu Ngạo Giang Hồ', 165000, 38, 'Cuộc tranh đoạt quyền lực chốn giang hồ.', 'Quang Trung', 3),
                                                                      ('Bạch Dạ Hành', 155000, 25, 'Tiểu thuyết trinh thám – tâm lý đặc sắc.', 'Văn Thành', 2),
                                                                      ('Sống', 120000, 60, 'Tác phẩm nhân văn sâu sắc về số phận con người.', 'Văn Thành', 1),
                                                                      ('Không Gia Đình', 130000, 55, 'Câu chuyện cảm động về nghị lực và tình người.', 'Tiến Đạt', 2);

INSERT INTO tag (name) VALUES
                           ('Lịch sử'),
                           ('Kinh điển'),
                           ('Chính kịch'),
                           ('Giải trí'),
                           ('Văn học mạng');

INSERT INTO book_tag (id_book, id_tag) VALUES
-- Book 1
(1, 1),
(1, 2),
(1, 3),

-- Book 2
(2, 2),
(2, 4),

-- Book 3
(3, 1),
(3, 2),
(3, 5),

-- Book 4
(4, 2),
(4, 5),
(5,3),
(6,4);
INSERT INTO account (username, password, role) VALUES
                                                   ('admin', '123', 'ADMIN'),
                                                   ('hi', '123', 'USER'),
                                                   ('tri', '123', 'USER'),
                                                   ('long', '123', 'USER'),
                                                   ('ch', '123', 'USER');

insert into payment_type(name,rate) values
                                        ('Tiền mặt',0),
                                        ('Ví điện tử',5),
                                        ('Visa',10);
INSERT INTO customer (id_account, name, phone, email, address)
VALUES
    (2, 'Nguyen Van A', '0901000001', 'a@example.com', '123 Đường A, Quận 1'),
    (3, 'Tran Thi B', '0901000002', 'b@example.com', '456 Đường B, Quận 2'),
    (4, 'Le Van C', '0901000003', 'c@example.com', '789 Đường C, Quận 3'),
    (5, 'Pham Thi D', '0901000004', 'd@example.com', '101 Đường D, Quận 4');

insert into chapter(id_book,chapter_unlock) values
    (1,3);

