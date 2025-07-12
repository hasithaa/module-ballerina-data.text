# Text File Parser Module for Ballerina

## Overview

A streaming text file parser for EDI-style files. This module supports configurable row formats and produces structured Ballerina records. It is designed for performance, tolerance, and flexibility in handling loosely structured text files that resemble—but are not strictly—EDI-compliant.

- **Input**: `stream<byte[]>` (chunked byte stream)
- **Output**: Ballerina `record`s in batches via a stream interface

---

## Input Format

- Each file is assumed to be line-oriented (`\n` as the record separator)
- File layout:
  - Optional **header row**
  - One or more **data rows**
  - Optional **trailer row**
- Each row is:
  - Delimited (e.g., comma, pipe, tab)
  - Or fixed-width (defined column sizes)

---

## Row Delimiter Support

- Supported delimiters:
  - Comma `,`
  - Pipe `|`
  - Tab `\t`
  - Fixed-width columns (requires explicit width specification)

---

## Configuration Schema (`TextFileSchema`)

A user-defined schema describes how to interpret the text file:

- `delimiter`: `"|" | "," | "\t" | "FIXED"`
- `encoding`: Text encoding (e.g., `"UTF-8"`)
- `recordTypes`: Array of row type definitions:
  - `identifier`: Row type tag (e.g., `"HDR"`, `"DATA"`, `"TRL"`)
  - `shape`: Ballerina `record` type describing the row structure
  - `discriminatorCol`: Column index used to identify row type
  - `fixedWidths`: Array of column widths (only if `delimiter = "FIXED"`)
- `batchSize`: Number of data rows returned per batch

---

## Parser Behavior

- Input: `stream<byte[]>` (processed as line stream)
- Output:
  - `nextBatch()`: Returns `record[]` for the next batch of data rows
  - `getHeader()`: Returns a `future<record {}?>` representing the header row
  - `getTrailer()`: Returns a `future<record {}?>` representing the trailer row

---

## Features

- Efficient, streaming, batch-wise parsing of large files
- Lazy and asynchronous access to header and trailer rows
- Optional handling of:
  - Blank or malformed rows
  - Trimming whitespace
  - Lenient or strict validation modes

---

## Constraints

- Row types must be distinguishable using a known discriminator column
- Batch size and delimiter type must be predefined in the schema
- Fixed-width support requires per-record width definitions

---

## Comparison with Existing Ballerina EDI Parser

The proposed text file parser differs from the official [Ballerina EDI parser](https://github.com/ballerina-platform/module-ballerina-edi) in key areas:

### 🔹 Purpose and Tolerance

| Feature              | Ballerina EDI Parser                        | Proposed Text File Parser                              |
|---------------------|---------------------------------------------|--------------------------------------------------------|
| Format Compliance   | Requires strict EDI compliance (e.g., X12)  | Tolerates loosely structured or non-compliant formats  |
| Use Case            | Formal EDI document processing              | Ad-hoc or legacy system integration                    |
| Segment Parsing     | Yes (ISA, GS, ST, etc.)                     | Not required; each line is an independent record       |
| Validation          | EDI schema-based validation                 | Simple configuration-based mapping                     |

---

### 🔹 Input Characteristics

- **Record separator**: Assumed to be newline (`\n`)
- **Granularity**: One logical record per line
- **EDI Envelope Segments**: Not required (e.g., no ISA/GS/IEA)
- **Lenient Parsing**: Suitable for:
  - Loosely structured EDI-like formats
  - Legacy mainframe exports
  - Manually created text files

---

### 🔹 Summary

This module is a **lightweight, fault-tolerant, streaming parser** for newline-separated text files. It is not intended to replace the EDI parser, but to complement it in integration scenarios where full EDI compliance is not guaranteed.

---
