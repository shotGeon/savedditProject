2021_07_09_02

(4) LIKE ������
   .������ ���� �� ���
   .���ϵ�ī��� '%'�� '_'�� ���Ǿ� ���� ���ڿ��� ����
   .'%': '%'�� ���� ��ġ ������ ��� ���ڿ��� ����
    EX)'����%':'����'���� �����ϴ� ��� �ܾ�� ������
       '��%��':ù ���ڰ� '��'�̰� ������ ���ڰ� '��'�� ��� �ܾ�� ����
       '%��'  :�����ڰ� '��'�� ��� �ܾ�� ����

��뿹)ȸ�����̺��� ������ �����ϴ� ȸ������ ��ȸ�Ͻÿ�(ȸ����ȣ,ȸ����,�ּ�,����,���ϸ���)

     SELECT MEM_ID AS ȸ����ȣ,
            MEM_NAME AS ȸ����,
            MEM_ADD1||MEM_ADD2 AS �ּ�,
            MEM_JOB AS ����,
            MEM_MILEAGE AS ���ϸ���
            
        FROM MEMBER
        WHERE MEM_ADD1 LIKE'����%';
����)��ٱ������̺��� 2005�� 7�� �Ǹ���Ȳ�� ��ȸ�Ͻÿ�.(����,��ǰ�ڵ�,�Ǹż���)
          
          SELECT TO_DATE(SUBSTR(CART_NO,1,8)) AS ����,
                 CART_PROD AS ��ǰ�ڵ�,
                 CART_QTY AS �Ǹż���
            FROM CART
            WHERE SUBSTR(CART_NO,1,8) BETWEEN '20050601' AND '20050631';
            
            SELECT TO_DATE(SUBSTR(CART_NO,1,8)) AS ����,
                 CART_PROD AS ��ǰ�ڵ�,
                 CART_QTY AS �Ǹż���
            FROM CART
            WHERE SUBSTR(CART_NO,1,6) BETWEEN '200506' AND '200507';