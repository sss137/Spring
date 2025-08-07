USE db_file;

# 공지사항 목록 + 각 공지사항에 포함된 첨부 개수
SELECT n.nid, n.title, n.content, COUNT(a.aid) AS attach_count
  FROM tbl_notice AS n LEFT JOIN tbl_attach AS a
    ON n.nid = a.nid
 GROUP BY n.nid, n.title, n.content
 ORDER BY nid DESC
 LIMIT 0, 20;