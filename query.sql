INSERT INTO wallets (
        id,
        user_id,
        balance,
        created_at,
        updated_date,
        created_by,
        wallet_number
    )
VALUES (
        1,
        1,
        1000.00,
        '2025-03-13 10:00:00',
        '2025-03-13 10:00:00',
        'user',
        1234567
    );
INSERT INTO transactions (
        id,
        wallet_id,
        amount,
        type,
        created_at,
        updated_date,
        created_by,
        status,
        transaction_reference,
        wallet_number
    )
VALUES (
        1,
        1,
        200.00,
        'DEPOSIT',
        '2025-03-13 11:00:00',
        '2025-03-13 11:00:00',
        'user',
        'COMPLETED',
        'TXN_1234',
        1234567
    );