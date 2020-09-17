import sqlite3
from contextlib import closing
db_file = "sqliteOnline.db"
db_con = sqlite3.connect(db_file)
try:
    with closing(db_con.cursor()) as cursor:
        query = "select * from demo"
        cursor.execute(query)
        data = cursor.fetchall()
        print(data)
except sqlite3.OperationalError as e:
    print(str(e))


