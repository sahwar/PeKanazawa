※1
本来ならSubProject化すると思いますが、研修用の為、Projectは一本で行います。

※2
DBは、TERを採用します。いろいろな機能を追加するため。また、初期段階では、Modelを決めきれないため。

※3
パッケージ構成図(本来ならドメイン層とアプリ層を分けるべきだが、研修用Projectの為、パッケージ構成をProject構成毎としている)
jp
    ┗co
        ┗pekanazawa
                ┣auth(課題用の為、あえて作成している)
                ┃      ┣web
                ┃      ┃  ┣***Controller.java
                ┃      ┃  ┗***Controller.java
                ┃      ┗domain
                ┃           ┣***Service.java
                ┃           ┣entity
                ┃           ┗repository
                ┣pcManagement
                ┃      ┣controller
                ┃      ┗service
                ┃           ┣entity
                ┃           ┗repository
                ┣lunch
                ┃      ┣controller
                ┃      ┗service
                ┃           ┣entity
                ┃           ┗repository
                ┗utility



 