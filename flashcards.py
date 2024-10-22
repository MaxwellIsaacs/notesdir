#!/usr/bin/env python3

import random
import sys
import textwrap
from colorama import init, Fore, Style
from termcolor import colored

# Initialize colorama
init(autoreset=True)


# Vocab data as a list of dictionaries
vocab_list = [
    {
        "term": "Flow Variable",
        "definition": "A variable that represents a rate at which something happens. Basically a variable with respect to time (kinda like the derivative).",
        "example": "The change in the demand within a given month."
    },
    {
        "term": "Stock Variable",
        "definition": "A scalar value, a variable that doesn't vary or depend on time.",
        "example": "The amount of money someone has at a given time."
    },
    {
        "term": "Ceteris Paribus",
        "definition": "All other things considered as constant.",
        "example": "Understanding how the demand of a product changes with the price, ceteris paribus."
    },
    {
        "term": "Desired Quantity",
        "definition": "The amount that consumers want to purchase when faced with a particular price of the product, other products' prices, their incomes, and everything else that might matter.",
        "example": "How much weed I want to buy right now, even if I won't actually buy that much."
    },
    {
        "term": "Quantity Demanded",
        "definition": "The amount of a certain product purchased over a given period of time (flow variable).",
        "example": "How much people that buy Coco Puffs in a given week."
    },
    {
        "term": "Quantity Supplied",
        "definition": "The amount that the seller wants to sell in a given period (flow variable).",
        "example": "How many bottles of mouthwash Rite Aid wants to sell in a two-month period."
    },
    {
        "term": "Quantity Sold or Quantity Exchanged",
        "definition": "How much the seller will actually sell (flow variable).",
        "example": "How many bottles of lean my plug sells in 3 months."
    },
    {
        "term": "Market",
        "definition": "A system where consumers and producers negotiate the exchange of goods and services.",
        "example": "The pencil market, where buyers buy pencils and sellers sell pencils."
    },
    {
        "term": "Equilibrium",
        "definition": "Where the supply and demand curve meet, representing the price that optimizes the amount produced and the amount purchased such that there is no surplus.",
        "example": "See the math section for details."
    },
    {
        "term": "Exogenous",
        "definition": "Independent variable.",
        "example": "The variables that affect supply and demand shifts."
    },
    {
        "term": "Endogenous",
        "definition": "Dependent variables.",
        "example": "Equilibrium price and quantity."
    },
    {
        "term": "Absolute Price",
        "definition": "The price of something as a scalar value.",
        "example": "A gram costs $10."
    },
    {
        "term": "Relative Price",
        "definition": "The ratio of two absolute prices, conveying how a price changes relative to another price.",
        "example": "How the price of carrots changes based on the price of other veggies."
    },
    {
        "term": "Elasticity",
        "definition": "How reliant demand is on price.",
        "example": "A market like diabetes insulin has very low elasticity since you need it to survive."
    },
    {
        "term": "Total Expenditure",
        "definition": "How much money the producer makes, or how much the consumer spends (Price * Quantity).",
        "example": "10 Elmo dolls were made at $10 each, so Disney makes $100 revenue."
    },
    {
        "term": "Tax Incidence",
        "definition": "The question of who holds the burden of taxes, the producer or the consumer.",
        "example": "In the case of cigarettes, the consumer bears the burden because the elasticity of demand is lower than that of supply."
    },
    {
        "term": "Inferior Goods",
        "definition": "A good where demand falls with rising income.",
        "example": "Scratch-off tickets."
    },
    {
        "term": "Normal Goods",
        "definition": "A good where demand rises with rising income.",
        "example": "Air conditioning."
    },
    {
        "term": "Cross Elasticity of Demand",
        "definition": "The elasticity of quantity demanded relative to the percent change in the price of another good.",
        "example": "The elasticity for the demand for combustion engine cars as the price of EVs drops."
    },
    {
        "term": "Price Floor",
        "definition": "A minimum price set by the government.",
        "example": "Minimum wage is a price floor on the cost of labor."
    },
    {
        "term": "Price Ceiling",
        "definition": "A maximum price set by the government.",
        "example": "Rent control or the price of certain vital medications."
    },
    {
        "term": "Sellers' Preferences",
        "definition": "When a seller keeps a product under the counter and only sells it to selected customers.",
        "example": "Like when the plug got some new gas but only sells it to his mans."
    },
    {
        "term": "Hidden Markets",
        "definition": "Black market; a market that violates legal price control.",
        "example": "The black market for prescription medication."
    },
    {
        "term": "Output Quota",
        "definition": "A minimum or maximum value that a supplier is forced to adhere to.",
        "example": "There is a quota on the number of taxi drivers a company can deploy to limit overcrowding in the streets."
    }
]

random.shuffle(vocab_list)

def flashcard_test(vocab_list):
    done_count = 0  # Counter for completed flashcards
    total_vocab = len(vocab_list)
    correct_answers = incorrect_answers = 0

    while vocab_list:
        vocab = vocab_list.pop(0)  # Get the first vocab entry
        print("\n" + "="*50)
        print(center_text(f"Term: {colored(vocab['term'], 'yellow')}"))

        user_input = input(center_text("Type Flip [f] to see the definition and example, Next [n] to skip, or Stop [s] to exit: ")).lower()

        if user_input == 'f':
            # Reveal the definition and example
            print("\n" + center_text(Style.BRIGHT + "Definition:"))
            print(center_text(bold_text(vocab['definition'])))
            print("\n" + center_text(Style.BRIGHT + "Example:"))
            print(center_text(vocab['example']))

            # Check correctness
            is_correct = input(center_text("Did you get it right? (1 for yes, 0 for no): ")).strip()
            if is_correct == '1':
                correct_answers += 1
                print(center_text(Fore.GREEN + "Correct!"))
            else:
                incorrect_answers += 1
                print(center_text(Fore.RED + "Incorrect!"))

            done_count += 1
            print("\n" + center_text(f"Progress: {done_count}/{total_vocab} flashcards done"))
            print(center_text(f"{Fore.GREEN}{correct_answers} correct, {Fore.RED}{incorrect_answers} incorrect"))

        elif user_input == 'n':
            done_count += 1
            print("\n" + center_text(f"Progress: {done_count}/{total_vocab} flashcards done"))
        elif user_input == 's':
            sys.exit()

        else:
            print(center_text(Fore.RED + "Invalid input. Please type 'f', 'n', or 's'."))

        if not vocab_list:
            print("\n" + center_text(Fore.YELLOW + "You have completed all the flashcards!"))

# Helper function to center the text
def center_text(text, width=50):
    return textwrap.fill(text, width=width).center(width)

# Helper function to bolden text
def bold_text(text):
    return Style.BRIGHT + text

# Run the flashcard test
flashcard_test(vocab_list)
