package com.project.expense.mapper;

import com.project.expense.dto.CategoryDto;
import com.project.expense.dto.ExpenseDto;
import com.project.expense.entity.Category;
import com.project.expense.entity.Expense;

public class ExpenseMapper {

    // Map Expense entity to ExpenseDto
    public static ExpenseDto mapToExpenseDto(Expense expense){
        return new ExpenseDto(
                expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                )
        );
    }

    // Map ExpenseDto to Expense entity
    public static Expense mapToExpense(ExpenseDto expenseDto){
        Category category = new Category();
        category.setId(expenseDto.categoryDto().id());

        return new Expense(
                expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                category
        );
    }
}
