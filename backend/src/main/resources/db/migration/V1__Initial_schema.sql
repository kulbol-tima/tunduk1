-- Create applications table
CREATE TABLE applications (
    id BIGSERIAL PRIMARY KEY,
    registration_number VARCHAR(50) NOT NULL UNIQUE,
    application_date DATE NOT NULL,
    applicant_full_name VARCHAR(255) NOT NULL,
    applicant_pin VARCHAR(14) NOT NULL UNIQUE,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    passport_series VARCHAR(10) NOT NULL,
    passport_number VARCHAR(20) NOT NULL,
    family_status VARCHAR(50) NOT NULL,
    previous_benefit BOOLEAN,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

-- Create family_members table
CREATE TABLE family_members (
    id BIGSERIAL PRIMARY KEY,
    application_id BIGINT NOT NULL REFERENCES applications(id),
    full_name VARCHAR(255) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    birth_date DATE NOT NULL,
    pin VARCHAR(14) NOT NULL UNIQUE,
    passport VARCHAR(50),
    relationship VARCHAR(50) NOT NULL,
    citizenship VARCHAR(100) NOT NULL
);

-- Create recipients table
CREATE TABLE recipients (
    id BIGSERIAL PRIMARY KEY,
    application_id BIGINT NOT NULL REFERENCES applications(id),
    benefit_amount NUMERIC(10, 2) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    region_coefficient NUMERIC(5, 2),
    additional_coefficient NUMERIC(5, 2),
    bonus NUMERIC(10, 2),
    status VARCHAR(50) NOT NULL
);

-- Create payments table
CREATE TABLE payments (
    id BIGSERIAL PRIMARY KEY,
    recipient_id BIGINT NOT NULL REFERENCES recipients(id),
    amount NUMERIC(10, 2) NOT NULL,
    payment_date DATE NOT NULL,
    bank_account VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL
);

-- Create income_data table
CREATE TABLE income_data (
    id BIGSERIAL PRIMARY KEY,
    family_member_id BIGINT NOT NULL REFERENCES family_members(id),
    income_type VARCHAR(100) NOT NULL,
    amount NUMERIC(12, 2) NOT NULL,
    period VARCHAR(50) NOT NULL,
    occupation VARCHAR(255),
    education_expenses NUMERIC(12, 2),
    business_activity VARCHAR(255),
    land_area NUMERIC(10, 4),
    livestock VARCHAR(255),
    bank_deposits NUMERIC(12, 2)
);

-- Create recalculations table
CREATE TABLE recalculations (
    id BIGSERIAL PRIMARY KEY,
    recipient_id BIGINT NOT NULL REFERENCES recipients(id),
    recalculation_type VARCHAR(100) NOT NULL,
    old_amount NUMERIC(10, 2) NOT NULL,
    new_amount NUMERIC(10, 2) NOT NULL,
    start_date DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    source_event VARCHAR(255)
);

-- Add indexes for performance on foreign keys and frequently queried columns
CREATE INDEX idx_applications_status ON applications(status);
CREATE INDEX idx_applications_applicant_pin ON applications(applicant_pin);
CREATE INDEX idx_family_members_application_id ON family_members(application_id);
CREATE INDEX idx_family_members_pin ON family_members(pin);
CREATE INDEX idx_recipients_application_id ON recipients(application_id);
CREATE INDEX idx_payments_recipient_id ON payments(recipient_id);
CREATE INDEX idx_income_data_family_member_id ON income_data(family_member_id);
CREATE INDEX idx_recalculations_recipient_id ON recalculations(recipient_id);
