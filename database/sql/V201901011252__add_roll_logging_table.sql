CREATE TABLE claim_no_history (
  claim_no VARCHAR (50) PRIMARY KEY,
  create_date IMESTAMP DEFAULT NOW()
);