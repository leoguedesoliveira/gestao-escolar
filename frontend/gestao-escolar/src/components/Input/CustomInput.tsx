import React, { useState } from "react";

interface CustomInputProps {
  type?: string;
  label?: string;
  value: string;
  onChange: (value: string) => void;
  placeholder?: string;
  validate?: (value: string) => string | null;
  className?: string;
}

const CustomInput: React.FC<CustomInputProps> = ({
  type = "text",
  label,
  value,
  onChange,
  placeholder = "",
  validate,
  className = "",
}) => {
  const [error, setError] = useState<string | null>(null);

  const handleBlur = () => {
    if (validate) {
      const validationError = validate(value);
      setError(validationError);
    }
  };

  return (
    <div className={`mb-4 ${className}`}>
      {label && <label className="block text-sm font-medium mb-2">{label}</label>}
      <input
        type={type}
        value={value}
        onChange={(e) => {
          onChange(e.target.value);
          if (error) setError(null);
        }}
        onBlur={handleBlur}
        placeholder={placeholder}
        className={`w-full p-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 transition ${
          error ? "border-red-500" : "border-gray-300"
        }`}
      />
      {error && <p className="text-red-500 text-sm mt-1">{error}</p>}
    </div>
  );
};

export default CustomInput;
